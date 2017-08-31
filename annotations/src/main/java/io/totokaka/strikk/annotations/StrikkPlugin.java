package io.totokaka.strikk.annotations;

import org.bukkit.plugin.java.JavaPlugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for a plugin that should have it's plugin.yml generated by Strikk.
 *
 * <p>
 *     This annotation should only be applied to classes that extend {@link JavaPlugin},
 *     and there may only be one instance of this annotation for each compiled module.
 *     The info declared in the annotation will be used to generate the plugin.yml file.
 * </p>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface StrikkPlugin {

    /**
     * The name of this plugin.
     *
     * <ul>
     *     <li>Must consist of alphanumeric characters and/or underscores</li>
     *     <li>Will determine the name of this plugins data folder</li>
     * </ul>
     *
     * @return the name of this plugin
     */
    String name();

    /**
     * The version of the plugin.
     *
     * <ul>
     *     <li>May be an arbitrary string, although Schematic Versioning is recommended</li>
     *     <li>Will be displayed with the /version &lt plugin &gt command</li>
     * </ul>
     *
     * @return The version of the plugin
     */
    String version();

    /**
     * A human readable description of the plugin.
     *
     * <ul>
     *     <li>May have multiple lines</li>
     *     <li>Will be displayed with the /version &lt plugin &gt command</li>
     * </ul>
     *
     * @return A human readable description of the plugin
     */
    String description() default "";

    /**
     * An unique identifier of the plugin author.
     *
     * <p>
     *     May be a name, nickname or email of the main developer. Will be merged into authors.
     * </p>
     *
     * @return An unique identifier of the main plugin Author
     */
    String author() default "";

    /**
     * List of contributors to the plugin.
     *
     * <p>
     *     Follows same rules as author, and will be merged with it.
     * </p>
     *
     * @return Contributors to the plugin
     */
    String[] authors() default {};

    /**
     * The plugin's or author's website.
     *
     * @return the plugin's or author's website
     */
    String website() default "";

    /**
     * When during startup the plugin should be loaded.
     *
     * @see LoadTime
     * @return when the plugin should be loaded
     */
    LoadTime load() default LoadTime.POST_WORLD;

    /**
     * Indicates whether this plugin uses the CraftBukkit server's database.
     *
     * <p>
     *     CraftBukkit servers provide a database that may be used by plugins,
     *     if this field is set true.
     * </p>
     *
     * @return Whether this plugin uses the CraftBukkit server's database
     */
    boolean database() default false;

    /**
     * A list of plugins this plugin depends on.
     *
     * @return Plugins this plugin depends on
     */
    Dependency[] depend() default {};

    /**
     * The logging prefix for this plugin's logger.
     *
     * @return The logging prefix
     */
    String prefix() default "";

}
